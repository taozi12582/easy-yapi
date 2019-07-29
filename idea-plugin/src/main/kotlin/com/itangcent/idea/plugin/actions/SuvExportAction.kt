package com.itangcent.idea.plugin.actions

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.project.Project
import com.itangcent.common.exporter.ClassExporter
import com.itangcent.common.exporter.ParseHandle
import com.itangcent.idea.plugin.DataEventCollector
import com.itangcent.idea.plugin.api.export.EasyApiConfigReader
import com.itangcent.idea.plugin.api.export.IdeaParseHandle
import com.itangcent.idea.plugin.api.export.SimpleClassExporter
import com.itangcent.idea.plugin.api.export.suv.SuvApiExporter
import com.itangcent.intellij.config.ConfigReader
import com.itangcent.intellij.context.ActionContext
import com.itangcent.intellij.extend.guice.singleton
import com.itangcent.intellij.extend.guice.with
import com.itangcent.intellij.file.DefaultLocalFileRepository
import com.itangcent.intellij.file.LocalFileRepository

class SuvExportAction : ApiExportAction("Export Api") {

    private lateinit var dataEventCollector: DataEventCollector

    override fun actionPerformed(anActionEvent: AnActionEvent) {
        dataEventCollector = DataEventCollector(anActionEvent)

        load(dataEventCollector)

        dataEventCollector.disableDataReach()

        super.actionPerformed(anActionEvent)
    }

    override fun onBuildActionContext(builder: ActionContext.ActionContextBuilder) {

        super.onBuildActionContext(builder)

        builder.bind(DataContext::class) { it.toInstance(dataEventCollector) }

        builder.bind(ClassExporter::class) { it.with(SimpleClassExporter::class).singleton() }

        builder.bind(LocalFileRepository::class) { it.with(DefaultLocalFileRepository::class).singleton() }

        builder.bind(ParseHandle::class) { it.with(IdeaParseHandle::class).singleton() }

        builder.bind(ConfigReader::class) { it.with(EasyApiConfigReader::class).singleton() }

        builder.bind(SuvApiExporter::class) { it.singleton() }

    }

    private fun load(dataContext: DataContext) {
        dataContext.getData(CommonDataKeys.PSI_FILE)
        dataContext.getData(CommonDataKeys.NAVIGATABLE_ARRAY)
        dataContext.getData(CommonDataKeys.NAVIGATABLE)
        dataContext.getData(CommonDataKeys.EDITOR)
    }

    override fun actionPerformed(actionContext: ActionContext, project: Project?, anActionEvent: AnActionEvent) {
        val multipleApiExporter = actionContext.instance(SuvApiExporter::class)
        multipleApiExporter.showExportWindow()
    }
}
