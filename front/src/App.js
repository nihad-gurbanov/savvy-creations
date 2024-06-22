import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Home } from "./pages/Home";
import { Login } from "./pages/Login";
import { Signup } from "./pages/SignUp";
import { NotFoundPage } from "./pages/404";
import { Services } from "./pages/Services";
import { Talents } from "./pages/Talents";
import { Projects } from "./pages/Projects";
import { Terms } from "./pages/Terms";

function App() {
  return (
    <Router>
      <Routes>
        <Route>
          <Route path="/" element={<Home />} />
          <Route path="/services" element={<Services />} />
          <Route path="/talents" element={<Talents />} />
          <Route path="/projects" element={<Projects />} />
          <Route path="/login" element={<Login />} />
          <Route path="/sign-up" element={<Signup />} />
          <Route path="/terms" element={<Terms />} />
          <Route path="*" element={<NotFoundPage />} />
        </Route>
      </Routes>
    </Router>
  );
}

export default App;
