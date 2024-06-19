import { Header } from "../components/header";
import { Link } from "react-router-dom";
import { Fragment, useState } from "react";
import "./loginSignup.css";
import { Footer } from "../components/footer";

export function Login() {
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
  return (
    <Fragment>
      <Header isLoginPage={true} />
      <div className="container loginSignup">
        <div className="left-side">
          <div>
            <button className="active">Login</button>
            <button>
              <Link to="/sign-up" state={{ state: "company" }}>
                Sign Up as Organization
              </Link>
            </button>
            <button>
              <Link to="/sign-up" state={{ state: "talent" }}>
                Sign Up as Talent
              </Link>
            </button>
          </div>
          <img src="./assets/imgs/login.png" alt="" />
        </div>
        <div className="right-side">
          <form onSubmit={handleSubmit}>
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
            <input className="submit" type="submit" value="Login" />
            <hr />
            <a href="#">Lost Password</a>
          </form>
        </div>
      </div>
      <Footer isLoginPage={true} />
    </Fragment>
  );
}
