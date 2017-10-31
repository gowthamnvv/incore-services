import React from "react";
import { Route, IndexRoute } from "react-router";

import App from "./components/App";
import HomePage from "./containers/HomePage";
import ExecuteAnalysis from "./containers/ExecuteAnalysis";
import ResultsPage from "./containers/ResultsPage";
import FragilityExplorerPage from "./components/FragilityExplorerPage";

import config from "./app.config";

export default (
	<Route path={config.basePath} component={App}>
		<IndexRoute component={HomePage} />
		<Route path="Execute" component={ExecuteAnalysis} />
		<Route path="Results" component={ResultsPage} />
		<Route path="FragilityViewer" component={FragilityExplorerPage} />
		<Route path="FragilityViewer/:id" component={FragilityExplorerPage} />
	</Route>
);
