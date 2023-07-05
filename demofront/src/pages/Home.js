import axios from 'axios'
import React, {useEffect, useState} from 'react'
import {Link, useParams} from "react-router-dom"


export default function Home() {

    const [students, setStudents] = useState([]);

    const {id} = useParams()

    useEffect(()=>{
        loadStudents();
    }, []);

    const loadStudents = async () => {

        const result = await axios.get("http://localhost:8081/api/v1/student")
        setStudents(result.data);
    }

    const deleteStudent = async (id) => {

      const result = await axios.delete(`http://localhost:8081/api/v1/student/${id}`)
      loadStudents()
    }
  return (
    <div className="container">
        <div className='py-4'>
        <table className="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">DOB</th>
      <th scope="col">Age</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    {
        students.map((student, index) =>(
            <tr>
            <th scope="row" key={student.id}>{student.id}</th>
            <td>{student.name}</td>
            <td>{student.email}</td>
            <td>{student.dob}</td>
            <td>{student.age}</td>
            <td>
                <Link className="btn btn-outline-dark mx-2" to={`ViewStudent/${student.id}`}>View</Link>
                <Link className="btn btn-outline-warning mx-2"
                to= {`EditStudent/${student.id}`}>
                    Edit
                </Link>
                <button className="btn btn-outline-danger mx-2"
                onClick = {()=> deleteStudent(student.id)}>
                  Delete
                  </button>
            </td>
          </tr>
        ))
    }

  </tbody>
</table>
        </div>
    </div>
  )
}
