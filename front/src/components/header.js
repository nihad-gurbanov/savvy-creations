import React from "react";
import "./header.css";
import { Link } from "react-router-dom";

export function Header({ isLoginPage }) {
  return (
    <React.Fragment>
      <header>
        <nav className="container">
          <ul>
            <li>
              <a href="/" className="logo">
                Portal
              </a>
            </li>
            <li className="search">
              <input
                type="search"
                name="search"
                id="search"
                placeholder="Search for project..."
              />
              <i className="fa-solid fa-magnifying-glass"></i>
            </li>
            <li>
              <a href="#">Projects</a>
            </li>
            <li>
              <a href="#">Talents</a>
            </li>
            <li>
              <a href="#">Services</a>
            </li>
            {!isLoginPage ? (
              <>
                <li>
                  <Link
                    className="loginsignup"
                    to="/sign-up"
                    state={{ state: "talent" }}
                  >
                    Sign Up
                  </Link>
                </li>
                <li>
                  <a className="loginsignup" href="/login">
                    Login
                  </a>
                </li>
              </>
            ) : (
              <></>
            )}
          </ul>
        </nav>
      </header>
    </React.Fragment>
  );
}
