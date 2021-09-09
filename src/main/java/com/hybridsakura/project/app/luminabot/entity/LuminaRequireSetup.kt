package net.lz1998.pbbot.helper.entity

import java.io.Serializable

@Suppress("DuplicatedCode")
class LuminaRequireSetup : Serializable {
    var masterKeyword //  主要关键字，用于匹配单一内容或者
            : String? = null
    var secondKeyword //  次要关键字，可能用于命令或者其他
            : String? = null
    var otherKeywordList //  消息中侦测到的关键字表
            : List<String>? = null
    var isRequireKeywordMatch //  当且仅当[主]关键字存在且其他关键字不存在时，此项为true
            = false
    var hybridRespondMap //  进行回应的消息 <K:文字或图片 V:回复文字列表或回复图片的地址列表>
            : Map<String, List<String>>? = null
    var isDetectAtLumina //  是否在消息中侦测到艾特露米娜
            = false
    var isRequireAtLumina //  是否要回复 取决于 露米娜是否被艾特
            = false
    private var requireRespAt //  回复时是否 @(at) 对方 （和下方冲突）
            = false
    private var requireRespReply //  回复时是否 对消息进行回复 对方 （和上方冲突）
            = false
    private var respMode //  自动设置项 回复模式
            : String? = null
    var blackQQUserList //  QQ用户黑名单
            : List<Long>? = null
    var blackQQGroupList //  QQ群黑名单
            : List<Long>? = null

    fun isRequireRespAt(): Boolean {
        return requireRespAt
    }

    fun setRequireRespAt(requireRespAt: Boolean) {
        if ("lumina-reply_with_at" == respMode) {
            this.requireRespAt = true
            requireRespReply = false
        } else if ("lumina-reply_last_message" == respMode) {
            this.requireRespAt = false
            requireRespReply = true
        } else {
            this.requireRespAt = requireRespAt
            requireRespReply = !this.requireRespAt
        }
    }

    fun isRequireRespReply(): Boolean {
        return requireRespReply
    }

    fun setRequireRespReply(requireRespReply: Boolean) {
        when (respMode) {
            "lumina-reply_last_message" -> {
                this.requireRespReply = true
                requireRespAt = false
            }
            "lumina-reply_with_at" -> {
                this.requireRespReply = false
                requireRespAt = true
            }
            else -> {
                this.requireRespReply = requireRespReply
                requireRespAt = !this.requireRespReply
            }
        }
    }

    fun getRespMode(): String? {
        return respMode
    }

    fun setRespMode(respMode: String?) {
        if (requireRespAt && !requireRespReply) {
            this.respMode = "lumina-reply_with_at"
        } else if (!requireRespAt && requireRespReply) {
            this.respMode = "lumina-reply_last_message"
        } else {
            this.respMode = respMode
        }
    }

    companion object {
        private const val serialVersionUID = 9158483452708692944L
    }
}