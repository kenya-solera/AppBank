import React, { useState, useEffect } from 'react'
import { ApiContext } from '../contexts/ApiContext'
import axios from 'axios'
function Store({ children }) {
    const [user, setUser] = useState({
        lastName:"",
        userName:"",
        password:""
        });
  useEffect(() => {
    axios
      .get("http://localhost:8081/users/get/{userName}")
      .then((res) => {
        setUser(res.data)
      })
      .catch((error) => {
        console.log(error)
      })
  }, [])
  return (
    <ApiContext.Provider value={[user, setUser]}>
      {children}
    </ApiContext.Provider>
  )
}
export default Store