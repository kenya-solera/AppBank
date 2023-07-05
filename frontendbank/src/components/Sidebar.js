import React from 'react'
import { Link } from 'react-router-dom'

const Sidebar = () => {
  return (
    <div>
        <nav className = "text-center">
    <ul className="list-unstyled">
    <li classname="pt-4 text-dark">
    <Link to=""className="text-decoration-none text-dark">Home</Link>
    </li>
    <li className="pt-4 text-dark">
    <Link to=""className="text-decoration-none text-dark">My Accounts</Link>
    </li>
    <li className="pt-4">
    <Link to="BankAccounts"className="text-decoration-none text-dark">Bank Account</Link>
    </li>
    <li className="pt-4">
    <Link to="" className="text-decoration-none text-dark">Notifications</Link>
    </li>
    <li className="pt-4 text-dark">
    <Link to=""className="text-decoration-none text-dark">Log Out</Link>
    </li>
    </ul>
    </nav>
    </div>
  )
}

export default Sidebar