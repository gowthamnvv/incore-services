import React, { Component } from "react";
import { browserHistory } from "react-router";
import {
	TextField, GridTile, GridList, RaisedButton, Card, CardText, CardTitle, CardHeader, Paper,
	Divider
} from "material-ui";

type Props = {
	name: string
}

class HomePage extends Component {
	constructor(props) {
		super(props);

		this.state = {
			username: "",
			password: "",
			passwordErrorText: ""
		};

		this.changeUsername = this.changeUsername.bind(this);
		this.changePassword = this.changePassword.bind(this);
		this.login = this.login.bind(this);
	}

	changeUsername(event: Object) {
		this.setState({username: event.target.value});
	}

	changePassword(event: Object) {
		let password = event.target.value;

		if (password.length <= 8) {
			this.setState({
				passwordErrorText: "Your password must be at least 8 characters long"
			});
		} else {
			this.setState({
				passwordErrorText: ""
			});
		}

		this.setState({password: password});
	}

	login(event: Object) {
		//TODO: Login using a global state action
		//this.props.login(this.state.username, this.state.password);
		browserHistory.push("/FragilityViewer");
	}

	render() {

		return (
			<div className="center" style={{display: "block", margin: "auto", width: "500px", paddingTop: "10%"}}>
				<Paper zDepth={3} style={{padding: 20}}>
					<h2>IN-CORE v2 Login</h2>
					<Divider />
					<GridList cellHeight="auto" cols={1}>
						<GridTile>
							<TextField
								floatingLabelText="Username"
								value={this.state.username}
								onChange={this.changeUsername}
							/>
						</GridTile>

						<GridTile>
							<TextField
								floatingLabelText="Password"
								type="password"
								minLength={8}
								errorText={this.state.passwordErrorText}
								value={this.state.password}
								onChange={this.changePassword}
							/>
						</GridTile>

						<GridTile style={{paddingTop: "20px"}}>
							<RaisedButton primary={true} onClick={this.login} label="Login"/>
						</GridTile>
					</GridList>
				</Paper>
			</div>
		);

	}
}

export default HomePage;
