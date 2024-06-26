import { Header } from "../components/header";
import { Footer } from "../components/footer";
import { useAuth } from "../utils/AuthContext";
import { useNavigate } from "react-router-dom";
import "./profile.css";

import React from "react";

export function Profile() {
  const { setIsAuthenticated } = useAuth();
  const navigate = useNavigate();
  const handleLogout = () => {
    document.cookie =
      "token" + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie =
      "refreshToken" + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    setIsAuthenticated(false);
    navigate("/");
  };
  return (
    <React.Fragment>
      <Header isLoginPage={false} activePage={"talents"} />
      <h1 className="coming-soon">Coming Soon...</h1>
      <div className="logoutButton">
        <button onClick={handleLogout}>Log out</button>
      </div>
      <Footer isLoginPage={false} pin={true} />
    </React.Fragment>
  );
}
