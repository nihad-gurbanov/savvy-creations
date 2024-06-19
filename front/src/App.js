import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Home } from "./pages/home";
import { Login } from "./pages/login";
import { Signup } from "./pages/signup";
import { NotFoundPage } from "./pages/404";
import { Services } from "./pages/services";
import { Talents } from "./pages/talents";
import { Projects } from "./pages/projects";
import { Terms } from "./pages/terms";

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
