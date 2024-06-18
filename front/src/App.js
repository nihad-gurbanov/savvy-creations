import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Home } from "./pages/home";
import { Login } from "./pages/login";
import { Signup } from "./pages/signup";

function App() {
  return (
    <Router>
      <Routes>
        <Route>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login state={"login"} />} />
          <Route path="/sign-up" element={<Signup />} />
        </Route>
      </Routes>
    </Router>
  );
}

export default App;
