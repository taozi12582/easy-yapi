package com.itangcent.idea.plugin.api.export

import com.itangcent.intellij.config.rule.*

object ClassExportRuleKeys {

    val MODULE: RuleKey<String> = SimpleRuleKey("module", StringRule::class,
            StringRuleMode.SINGLE)

    val IGNORE: RuleKey<Boolean> = SimpleRuleKey("ignore", BooleanRule::class,
            BooleanRuleMode.ANY)

    //filter class for methodDoc(rpc)
    val CLASS_FILTER: RuleKey<Boolean> = SimpleRuleKey("mdoc.class.filter", BooleanRule::class,
            BooleanRuleMode.ANY)

    //filter method for methodDoc(rpc)
    val METHOD_FILTER: RuleKey<Boolean> = SimpleRuleKey("mdoc.method.filter", BooleanRule::class,
            BooleanRuleMode.ANY)

    val PARAM_DOC: RuleKey<String> = SimpleRuleKey("doc.param", StringRule::class,
            StringRuleMode.MERGE_DISTINCT)

    val METHOD_DOC: RuleKey<String> = SimpleRuleKey("doc.method", StringRule::class,
            StringRuleMode.MERGE_DISTINCT)

    val CLASS_DOC: RuleKey<String> = SimpleRuleKey("doc.class", StringRule::class,
            StringRuleMode.MERGE_DISTINCT)

    val METHOD_ADDITIONAL_HEADER: RuleKey<String> = SimpleRuleKey("method.additional.header", StringRule::class,
            StringRuleMode.MERGE_DISTINCT)

    val METHOD_ADDITIONAL_PARAM: RuleKey<String> = SimpleRuleKey("method.additional.param", StringRule::class,
            StringRuleMode.MERGE_DISTINCT)

    val METHOD_ADDITIONAL_RESPONSE_HEADER: RuleKey<String> = SimpleRuleKey("method.additional.response.header", StringRule::class,
            StringRuleMode.MERGE_DISTINCT)

    val PARAM_REQUIRED: RuleKey<Boolean> = SimpleRuleKey("param.required", BooleanRule::class,
            BooleanRuleMode.ANY)

    val PARAM_IGNORE: RuleKey<Boolean> = SimpleRuleKey("param.ignore", BooleanRule::class,
            BooleanRuleMode.ANY)

    val FIELD_REQUIRED: RuleKey<Boolean> = SimpleRuleKey("field.required", BooleanRule::class,
            BooleanRuleMode.ANY)

    val CLASS_PREFIX_PATH: RuleKey<String> = SimpleRuleKey("class.prefix.path", StringRule::class,
            StringRuleMode.SINGLE)

}
