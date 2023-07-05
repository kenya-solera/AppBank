import React from 'react'
import { Link } from 'react-router-dom'

export default function NavBar() {
  return (
    <div>
        <nav className="navbar navbar-expand-lg bg-body-tertiary navbar-light">
  <div className="container-fluid">
    <Link className="navbar-brand display-6 fw-bold" to="/">Students CRUD App</Link>
    <button className="navbar-toggler" 
    type="button" 
    data-bs-toggle="collapse" 
    data-bs-target="#navbarSupportedContent" 
    aria-controls="navbarSupportedContent" 
    aria-expanded="false" 
    aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    </div>
    <Link className = "btn btn-outline-light bg-dark m-3" to="/AddStudent">Add Student</Link>
    </nav>
    </div>
  )
}
