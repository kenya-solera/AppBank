import React from "react";
import { Link, useParams} from "react-router-dom";
import { useState, useEffect } from "react";
import axios from 'axios'

const ViewStudent = () => {
    const [student, setStudent] = useState({
        name: "",
        email: "",
        dob: "",
        age: 0
      });

const {id} = useParams();

useEffect(() => {
loadStudent()
}, [])


const loadStudent = async ()=>{
    const result = await axios.get(`http://localhost:8081/api/v1/student/${id}`)
    setStudent(result.data);
  }
  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 ">
          <h2 className="text-center m-4 display-6">Student Details</h2>
          <div className = "card">
                <div className="card-header">
                        <b>Details of student id: {student.id}</b>
                        <ul className="list-group list-group-flush">
                            <li className="list-group-item">
                                <b>Name:</b>
                                {student.name}
                            </li>
                            <li className="list-group-item">
                                <b>Email:</b>
                                {student.email}
                            </li>
                            <li className="list-group-item">
                                <b>Day of Birth:</b>
                                {student.dob}
                            </li>
                            <li className="list-group-item">
                                <b>Age:</b>
                                {student.age}
                            </li>
                        </ul>
                </div>
          </div>
          <Link className="btn btn-outline-dark my-2" to="/">
            Back to home
          </Link>
        </div>
      </div>
    </div>
  );
};

export default ViewStudent;
