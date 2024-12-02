class UserStore {
    constructor() {
        this.state = {
            isAuthenticated: false,
            user: null,
        };
    }

    login(user) {
        console.log('UserStore.login', user);
        this.state.isAuthenticated = true;
        this.state.user = user;
    }

    logout() {
        this.state.isAuthenticated = false;
        this.state.user = null;
    }

    getState() {
        return this.state;
    }
}

const userStore = new UserStore();
export default userStore;