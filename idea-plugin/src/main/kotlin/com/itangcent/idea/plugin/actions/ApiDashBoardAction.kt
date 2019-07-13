package com.itangcent.idea.plugin.actions

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.itangcent.common.exporter.ParseHandle
import com.itangcent.idea.plugin.api.dashboard.ApiDashBoard
import com.itangcent.idea.plugin.api.export.IdeaParseHandle
import com.itangcent.idea.plugin.api.export.postman.PostmanConfigReader
import com.itangcent.idea.plugin.config.RecommendConfigReader
import com.itangcent.intellij.config.ConfigReader
import com.itangcent.intellij.context.ActionContext
import com.itangcent.intellij.extend.guice.singleton
import com.itangcent.intellij.extend.guice.with
import com.itangcent.intellij.file.DefaultLocalFileRepository
import com.itangcent.intellij.file.LocalFileRepository
import com.itangcent.suv.http.ConfigurableHttpClientProvider
import com.itangcent.suv.http.HttpClientProvider

class ApiDashBoardAction : ApiExportAction("ApiDashBoard") {

    override fun onBuildActionContext(builder: ActionContext.ActionContextBuilder) {
        super.onBuildActionContext(builder)

        builder.bind(LocalFileRepository::class) { it.with(DefaultLocalFileRepository::class).singleton() }

        builder.bind(ParseHandle::class) { it.with(IdeaParseHandle::class).singleton() }
        builder.bind(ConfigReader::class, "delegate_config_reader") { it.with(PostmanConfigReader::class).singleton() }
        builder.bind(ConfigReader::class) { it.with(RecommendConfigReader::class).singleton() }
        builder.bind(HttpClientProvider::class) { it.with(ConfigurableHttpClientProvider::class).singleton() }


    }

    override fun actionPerformed(actionContext: ActionContext, project: Project?, anActionEvent: AnActionEvent) {
        val apiDashBoard = actionContext.instance(ApiDashBoard::class)
        apiDashBoard.showDashBoardWindow()
    }
}
