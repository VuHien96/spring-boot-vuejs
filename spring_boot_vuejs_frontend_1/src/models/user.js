export default class User {
    constructor(id, userName, password, name, role, token) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.role = role;
        this.token = token;
    }
}
