import {connect} from "react-redux";
import AnalysisSelectComponent from "../components/AnalysisSelect";
import {getAnalysisById} from "../actions/index";

const mapStateToProps = (state) => {
	return {
		analyses: state.analyses.analysesMetadata
	};
};

const mapDispatchToProps = (dispatch) => {
	return {
		onSelectAnalysis: (id) => {
			dispatch(getAnalysisById(id));
		}
	};
};

const AnalysisSelect = connect(mapStateToProps, mapDispatchToProps)(AnalysisSelectComponent);

export default AnalysisSelect;
