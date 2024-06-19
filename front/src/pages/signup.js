import { Header } from "../components/header";
import { Fragment, useState } from "react";
import "./loginSignup.css";
import { useLocation } from "react-router-dom";
import { Footer } from "../components/footer";
import { Link } from "react-router-dom";

export function Signup() {
  const location = useLocation();
  const initialPageState = location.state && location.state.state;
  const [pageState, setPageState] = useState(initialPageState);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const handleSubmit = async (e) => {
    e.preventDefault();

    const user = {
      username,
      password,
    };

    const response = await fetch("", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(user),
    });

    const data = await response.json();
    // onLoginSuccess(data.token); implement this
  };
  const talent = (
    <Fragment>
      <Header isLoginPage={true} />
      <div className="container loginSignup">
        <div className="left-side">
          <div>
            <button>
              <a href="/login">Login</a>
            </button>
            <button
              className={pageState === "company" ? "active" : ""}
              onClick={() => setPageState("company")}
            >
              Sign Up as Organization
            </button>
            <button
              className={pageState === "talent" ? "active" : ""}
              onClick={() => setPageState("talent")}
            >
              Sign Up as Talent
            </button>
          </div>
          <img src="./assets/imgs/signup.png" alt="" />
        </div>
        <div className="right-side">
          <form onSubmit={handleSubmit}>
            <div>
              <input type="text" name="firstname" placeholder="first name" />
              <input type="text" name="lastname" placeholder="last name" />
            </div>
            <select defaultValue={"profession"}>
              <option value="profession" hidden>
                profession
              </option>
              <option value="developer">Developer</option>
              <option value="cyberspecialist">Cyber Specialist</option>
              <option value="designer">Designer</option>
            </select>
            <input
              type="text"
              name="username"
              placeholder="username"
              onChange={(e) => setUsername(e.target.value)}
            />
            <input
              type="password"
              name="password"
              placeholder="password"
              onChange={(e) => setPassword(e.target.value)}
            />
            <div>
              <input type="checkbox" id="talentterms" />
              <label htmlFor="talentterms">
                <Link to="/terms" state={{ state: "talents" }}>
                  terms and conditions
                </Link>
              </label>
            </div>
            <input className="submit" type="submit" value="Sign Up" />
          </form>
        </div>
      </div>
      <Footer isLoginPage={true} />
    </Fragment>
  );
  const company = (
    <Fragment>
      <Header isLoginPage={true} />
      <div className="container loginSignup">
        <div className="left-side">
          <div>
            <button>
              <a href="/login">Login</a>
            </button>
            <button
              className={pageState === "company" ? "active" : ""}
              onClick={() => setPageState("company")}
            >
              Sign Up as Organization
            </button>
            <button
              className={pageState === "talent" ? "active" : ""}
              onClick={() => setPageState("talent")}
            >
              Sign Up as Talent
            </button>
          </div>
          <img src="./assets/imgs/signup.png" alt="" />
        </div>
        <div className="right-side">
          <form onSubmit={handleSubmit}>
            <div>
              <input type="text" name="firstname" placeholder="first name" />
              <input type="text" name="lastname" placeholder="last name" />
            </div>
            <input type="text" name="companyname" placeholder="company name" />
            <input
              type="text"
              name="username"
              placeholder="username"
              onChange={(e) => setUsername(e.target.value)}
            />
            <input
              type="password"
              name="password"
              placeholder="password"
              onChange={(e) => setPassword(e.target.value)}
            />
            <div>
              <input type="checkbox" id="companyterms" />
              <label htmlFor="companyterms">
                <Link to="/terms" state={{ state: "company" }}>
                  terms and conditions
                </Link>
              </label>
            </div>
            <input className="submit" type="submit" value="Sign up" />
          </form>
        </div>
      </div>
      <Footer isLoginPage={true} />
    </Fragment>
  );
  if (pageState === "company") {
    return company;
  } else if (pageState === "talent") {
    return talent;
  }
}
