import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import MapContainer from "./MapContainer";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {users: []}
    }

    componentDidMount() {
        fetch('http://localhost:8080/users')
            .then(response => response.json())
            .then(data => this.setState({users: data}));
    }

    render() {
    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo" />
                <h1 className="App-title">Welcome to React</h1>
            </header>
            <div>
                <h2>User List</h2>
                <UserList users={this.state.users}/>
                <MapContainer/>
            </div>
        </div>
    );
  }
}

class UserList extends React.Component{
    render() {
        const users = this.props.users.map(user =>
            <User key={user} user={user}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>Name</th>
                </tr>
                {users}
                </tbody>
            </table>
        )
    }
}

class User extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.user.name}</td>
            </tr>
        )
    }
}

export default App;
