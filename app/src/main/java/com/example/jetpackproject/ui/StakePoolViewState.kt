package com.example.jetpackproject.ui

data class StakePoolViewState<T>(val state: State, val data: T?) {

    enum class State {
        SUCCESS,
        LOADING,
        ERROR,
        IDLE
    }

    companion object {
        fun <T> success(data: T): StakePoolViewState<T> {
            return StakePoolViewState(State.SUCCESS, data)
        }

        fun <T> loading(): StakePoolViewState<T> {
            return StakePoolViewState(State.LOADING, null)
        }

        fun <T> error(data: T): StakePoolViewState<T> {
            return StakePoolViewState(State.ERROR, data)
        }

        fun <T> idle(data: T): StakePoolViewState<T> {
            return StakePoolViewState(State.IDLE, data)
        }
    }
}
