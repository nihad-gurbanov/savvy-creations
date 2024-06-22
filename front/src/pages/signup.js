import { Header } from "../components/header";
import { Fragment, useState, useEffect } from "react";
import "./loginSignup.css";
import { useLocation } from "react-router-dom";
import { Footer } from "../components/footer";
import { Link } from "react-router-dom";
import { getProfessions } from "../requests/professionRequests";
import { baseURL } from "../utils/baseURL";

export function Signup() {
  const location = useLocation();
  const initialPageState = location.state && location.state.state;
  const [pageState, setPageState] = useState(initialPageState);
  const [professions, setProfessions] = useState([]);
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  useEffect(() => {
    getProfessions().then(
      (data) => {
        setProfessions(data);
      },
      (error) => {
        console.error("Error fetching professions:", error);
      }
    );
  }, []);
  const handleTalentSubmit = async (e) => {
    e.preventDefault();
    const professionId = document.querySelector("select").value;
    const user = {
      name,
      surname,
      username,
      password,
      professionId,
    };

    const response = await fetch(`${baseURL}/auth/talent/sign-up`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(user),
    });

    const data = await response.json();
    console.log(data);
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
          <form onSubmit={handleTalentSubmit}>
            <div>
              <input
                type="text"
                name="firstname"
                placeholder="first name"
                onChange={(e) => setName(e.target.value)}
                required
              />
              <input
                type="text"
                name="lastname"
                placeholder="last name"
                onChange={(e) => setSurname(e.target.value)}
                required
              />
            </div>
            <select defaultValue={"profession"} required>
              <option value="" hidden>
                profession
              </option>

              {professions.map((profession) => (
                <option key={profession.id} value={profession.id}>
                  {profession.name}
                </option>
              ))}
            </select>
            <input
              type="text"
              name="username"
              placeholder="username"
              onChange={(e) => setUsername(e.target.value)}
              required
            />
            <input
              type="password"
              name="password"
              placeholder="password"
              onChange={(e) => setPassword(e.target.value)}
              required
            />
            <div>
              <input type="checkbox" id="talentterms" required />
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
          <form onSubmit={handleTalentSubmit}>
            <div>
              <input
                type="text"
                name="firstname"
                placeholder="first name"
                required
              />
              <input
                type="text"
                name="lastname"
                placeholder="last name"
                required
              />
            </div>
            <input
              type="text"
              name="companyname"
              placeholder="company name"
              required
            />
            <input
              type="text"
              name="username"
              placeholder="username"
              onChange={(e) => setUsername(e.target.value)}
              required
            />
            <input
              type="password"
              name="password"
              placeholder="password"
              onChange={(e) => setPassword(e.target.value)}
              required
            />
            <div>
              <input type="checkbox" id="companyterms" required />
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
