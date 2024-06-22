import { Header } from "../components/header";
import { Link } from "react-router-dom";
import { Fragment, useState } from "react";
import "./loginSignup.css";
import { Footer } from "../components/footer";
// import { fieldLength } from "../utils/fieldCheck";
import { baseURL } from "../utils/baseURL";

export function Login() {
  // const [errorState, setErrorState] = useState("");
  const handleSubmit = async (e) => {
    e.preventDefault();

    const usernameField = document.getElementById("username");
    const passwordField = document.getElementById("password");
    // const checkUsername = fieldLength(usernameField, 6, 12);
    // const checkPassword = fieldLength(passwordField, 6, 12);
    // if (checkUsername === "" && checkPassword === "") {
    const username = usernameField.value;
    const password = passwordField.value;
    const user = {
      username,
      password,
    };

    const response = await fetch(`${baseURL}/auth/sign-in`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(user),
    });

    const data = await response.json();
    console.log(data);
    // setErrorState("");
    // onLoginSuccess(data.token); implement this
    // } else {
    //   if (checkUsername !== "") {
    //     setErrorState(checkUsername);
    //   } else {
    //     setErrorState(checkPassword);
    //   }
    // }
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
            {/* {errorState === "" ? <></> : <p className="error">{errorState}</p>} */}
            <input
              type="text"
              id="username"
              name="username"
              placeholder="username"
              required
            />
            <input
              type="password"
              id="password"
              name="password"
              placeholder="password"
              required
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
