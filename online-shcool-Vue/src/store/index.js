import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    count: 1,
    user: {
      id: 11703080326,
      
    }
  },
  mutations: {
    increment (state, amount) {
      state.count += amount.amount
    },
    updateUser (state, user) {
      state.user = user
    }
  },
  actions: {
    incrementAsync: (context, arcu) => {
      context.commit({
        type: 'increment',
        amount: arcu.amount
      })

      setTimeout(() => {
        context.commit({
          type: 'increment',
          amount: arcu.amount
        })
      }, 2000)
    }
  }
})

export default store
