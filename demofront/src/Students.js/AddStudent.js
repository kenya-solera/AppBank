import React from "react"
import {useState} from 'react'
import axios from 'axios'
import {Link, useNavigate} from "react-router-dom"

export default function AddStudent() {

    let navigate = useNavigate()

  const [student, setStudent] = useState({
    name: "",
    email: "",
    dob: ""
  });

  const {name, email, dob} = student;

  const onInpuChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8081/api/v1/student", student)
        navigate("/")
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 ">
          <h2 className="text-center m-4 display-6">Add Student</h2>
          <form onSubmit={(e) => onSubmit(e)}>
          <div className="mb-3">
            <label htmlFor="name" className="form-label">
              Name
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Introduce the student's name"
              name="name"
              value={name}
              onChange={(e) => onInpuChange(e)}
            />
          </div>
          <div className="mb-3">
            <label htmlFor="email" className="form-label">
              Email
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Introduce the student's email"
              name="email"
              value={email}
              onChange={(e) => onInpuChange(e)}
            />
          </div>
          <div className="mb-3">
            <label htmlFor="dob" className="form-label">
              DOB
            </label>
            <input
              type={"date"}
              className="form-control"
              placeholder="Introduce the student's day of birth"
              name="dob"
              value={dob}
              onChange={(e) => onInpuChange(e)}
            />
          </div>
          <button type="submit" className="btn btn-outline-dark m-3">
            Submit
          </button>
          <Link type="submit" className="btn btn-outline-danger m-3" to="/">
            Cancel
          </Link>
          </form>
        </div>
      </div>
    </div>
  );
}
