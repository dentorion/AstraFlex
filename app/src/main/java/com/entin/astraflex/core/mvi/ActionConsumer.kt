package com.entin.astraflex.core.mvi

interface ActionConsumer {
    fun consumeAction(action: ActionUi)
}
