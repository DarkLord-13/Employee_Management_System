import "./App.css";
import ListEmployeeComponent from "./components/ListEmployeeComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import { BrowserRouter, Route, Router, Routes } from "react-router-dom";
import EmployeeComponent from "./components/EmployeeComponent";

function App() {
	return (
		<>
			<BrowserRouter>
				<HeaderComponent />
				<Routes>
					{/* {http:localhost:3000} */}
					<Route path="/" element={<ListEmployeeComponent />} />

					{/* {http:localhost:3000/employees} */}
					<Route
						path="/employees"
						element={<ListEmployeeComponent />}
					/>

					{/* {http:localhost:3000/add-employees} */}
					<Route
						path="/add-employee"
						element={<EmployeeComponent />}
					/>

					{/* {http:localhost:3000/edit-employees} */}
					<Route
						path="/edit-employee/:id"
						element={<EmployeeComponent />}
					/>
				</Routes>
				<FooterComponent />
			</BrowserRouter>
		</>
	);
}

export default App;
