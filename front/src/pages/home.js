import { Header } from "../components/header";
import { Footer } from "../components/footer";
import React from "react";

export function Home() {
  return (
    <React.Fragment>
      <Header isLoginPage={false} />
      <section className="form-section container">
        <div className="form-div">
          <h2>Submit your project details</h2>
          <form action="#" className="projectForm">
            <div>
              <label htmlFor="nameInput">Name</label>
              <input
                type="text"
                name="name"
                id="nameInput"
                placeholder="Drone store"
              />
            </div>
            <div>
              <label htmlFor="typeInput">Type</label>
              <input
                type="text"
                name="type"
                id="typeInput"
                placeholder="Website"
              />
            </div>
            <div>
              <label htmlFor="categoryInput">Category</label>
              <input
                type="text"
                name="category"
                id="categoryInput"
                placeholder="E-commerce"
              />
            </div>
            <div>
              <label htmlFor="detailsInput">Details</label>
              <textarea name="details" id="detailsInput" rows="5"></textarea>
            </div>
            <div>
              <input type="submit" value="Submit project" />
            </div>
          </form>
        </div>
        <div className="img-div">
          <p>
            Near to <span>free</span> software
            <br />
            solutions <span>for startups!</span>
          </p>
          <img
            src="./assets/imgs/fun-3d-cartoon-illustration-indian-businessman-removebg-preview.png"
            alt="Image"
            height="350px"
          />
        </div>
      </section>
      <div className="section-headings">
        <h1>Some Solutions We Build</h1>
        <button className="see-all"> See All &gt;&gt;</button>
      </div>
      <section className="solutions-section container">
        <div>
          <img src="./assets/imgs/3054613-removebg-preview.png" alt="Mobile" />
          <p>Mobile IOS / Android</p>
        </div>
        <div>
          <img src="./assets/imgs/7922058-removebg-preview.png" alt="Desktop" />
          <p>Desktop App</p>
        </div>
        <div>
          <img
            src="./assets/imgs/Remove-bg.ai_1717687649624.png"
            alt="Android"
          />
          <p>Web Development</p>
        </div>
      </section>
      <div className="section-headings">
        <button className="see-all"> See All &gt;&gt;</button>
        <h1>Open Projects</h1>
      </div>
      <section className="projects-section container">
        <div className="project-card">
          <img src="./assets/imgs/unnamed (1).png" alt="PASHA" />
          <div>
            <p>Swift / SwiftUI B2B IOS App</p>
            <p className="p-with-span">
              <span>E-Commerce</span>Mobile IOS / Android
            </p>
          </div>
          <button>Details</button>
        </div>
        <div className="project-card">
          <img src="./assets/imgs/atb_logo_png2.png" alt="atb" />
          <div>
            <p>Kotlin / Java B2B Android App</p>
            <p className="p-with-span">
              <span>Fintech</span> Mobile IOS / Android
            </p>
          </div>
          <button>Details</button>
        </div>
        <div className="project-card">
          <img
            src="./assets/imgs/yMeSBSawXHna.jpeg"
            alt="International Bank of Azerbaijan"
          />
          <div>
            <p>Java / Backend web app</p>
            <p className="p-with-span">
              <span>Fintect</span> Web Development
            </p>
          </div>
          <button>Details</button>
        </div>
        <div className="project-card">
          <img src="./assets/imgs/instagram_feed180.jpg" alt="Holberton" />
          <div>
            <p>Ruby / Backend intranet</p>
            <p className="p-with-span">
              <span>Education</span> Web Development
            </p>
          </div>
          <button>Details</button>
        </div>
        <div className="project-card">
          <img
            src="./assets/imgs/UI1BU-Fakgao9hmQIFad784kGgRj6O8JOaDjWh4WbhE.jpeg"
            alt="SOCAR"
          />
          <div>
            <p>Java / Desktop App</p>
            <p className="p-with-span">
              <span>ERP</span> Desktop App
            </p>
          </div>
          <button>Details</button>
        </div>
        <div className="project-card">
          <img src="./assets/imgs/86GG_qN-_400x400.jpg" alt="PASHA" />
          <div>
            <p>C# / Desktop App</p>
            <p className="p-with-span">
              <span>Telecommunication</span> Desktop App
            </p>
          </div>
          <button>Details</button>
        </div>
      </section>
      <div className="section-headings">
        <h1>Top Talents</h1>
        <button className="see-all"> See All &gt;&gt;</button>
      </div>
      <section className="talents-section container">
        <div className="talent-card">
          <img src="./assets/imgs/400_400_2.jpg" alt="talent" />
          <p className="name">Huseyn Israfilov</p>
          <p className="profession">Backend Developer</p>
          <p className="success">Success rate: 90%</p>
          <button className="left-button">Details</button>
          <button className="right-button">Contact</button>
        </div>
        <div className="talent-card">
          <img src="./assets/imgs/400_400_3.jpg" alt="talent" />
          <p className="name">Nihad Gurbanov</p>
          <p className="profession">Backend Developer</p>
          <p className="success">Success rate: 90%</p>
          <button className="left-button">Details</button>
          <button className="right-button">Contact</button>
        </div>
        <div className="talent-card">
          <img src="./assets/imgs/400_400_6.jpg" alt="talent" />
          <p className="name">Murad Abbaszade</p>
          <p className="profession">Backend Developer</p>
          <p className="success">Success rate: 90%</p>
          <button className="left-button">Details</button>
          <button className="right-button">Contact</button>
        </div>
        <div className="talent-card">
          <img src="./assets/imgs/400_400_8.jpg" alt="talent" />
          <p className="name">Haji Mursalzada</p>
          <p className="profession">Backend Developer</p>
          <p className="success">Success rate: 90%</p>
          <button className="left-button">Details</button>
          <button className="right-button">Contact</button>
        </div>
      </section>
      <Footer />
    </React.Fragment>
  );
}
