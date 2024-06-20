import { Header } from "../components/header";
import { Footer } from "../components/footer";
import React from "react";
import "./projects_talents.css";

export function Talents() {
  return (
    <React.Fragment>
      <Header isLoginPage={false} activePage={"talents"} />
      <section className="container categorizedProject-section">
        <div className="left-side">
          <h2>Filter By Service</h2>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check">Full stack web development</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-2" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-2">Frontend development</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-3" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-3">Backend development</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-4" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-4">IOS development</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-5" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-5">Android development</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-6" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-6">Cross mobile development</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-7" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-7">Desktop development</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-8" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-8">UX UI Design</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-9" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-9">Data Science & Machine L...</label>
          </div>
          <h2>Filter By Category</h2>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-10" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-10">E-commerce</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-11" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-11">Education</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-12" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-12">ERP</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-13" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-13">Fintech</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-14" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-14">Customer Relationship Man...</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-15" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-15">Human Resources</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-16" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-16">Project Management</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-17" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-17">Content Management System</label>
          </div>
          <div className="project">
            <label class="switch">
              <input type="checkbox" id="check-18" />
              <span class="slider round"></span>
            </label>
            <label htmlFor="check-18">Healthcare</label>
          </div>
        </div>
        <div className="right-side">
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
        </div>
      </section>
      <Footer isLoginPage={false} />
    </React.Fragment>
  );
}
