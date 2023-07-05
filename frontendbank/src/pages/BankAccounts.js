import React from "react";
import Sidebar from "../components/Sidebar";
import axios from "axios";
import {Link, useParams} from 'react-router-dom';
import {useState, useEffect} from 'react';

export default function BankAccounts() {
    const [account, setAccount] = useState([]);

    const {id} = useParams()

    useEffect(()=>{

        loadAccounts();

    }, []);

    const loadAccounts = async () => {

        const result = await axios.get("http://localhost:8081/accounts")

        setAccount(result.data);

    }

    // const deleteAccount = async (id) => {

    //   const result = await axios.delete(`http://localhost:8081/accounts/${id}`)

    //   loadAccounts()

    // }
  return (
    <div className="container text-center">
      <div className="row">
        <div className="col-3">
          <Sidebar />
        </div>
        <div>
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
              {account.map((account, index) => (
                <tr>
                  <th scope="row" key={account.id}>
                    {account.id}
                  </th>

                  <td>{account.name}</td>

                  <td>{account.email}</td>

                  <td>{account.dob}</td>

                  <td>{account.age}</td>

                  <td>
                    <Link
                      className="btn btn-outline-dark mx-2"
                      to={`Viewaccount/${account.id}`}
                    >
                      View
                    </Link>

                    <Link
                      className="btn btn-outline-warning mx-2"
                      to={`Editaccount/${account.id}`}
                    >
                      Edit
                    </Link>

                    <button
                      className="btn btn-outline-danger mx-2"
                      // onClick={() => deleteaccount(account.id)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}
