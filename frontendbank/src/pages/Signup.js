import React, { useState } from 'react';

 

function Signup() {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    username: '',
    password: '',
    confirmPassword: ''
  });

 

  const { firstName, lastName, username, password, confirmPassword } = formData;

 

  const handleChange = e => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

 

  const handleSubmit = e => {
    e.preventDefault();
    // Lógica para enviar los datos del formulario
    console.log(formData);
    // Resetear los valores del formulario
    setFormData({
      firstName: '',
      lastName: '',
      username: '',
      password: '',
      confirmPassword: ''
    });
  };

 

  return (
    <div className="container">
        <div clasName="row">
            <div>
            <img src=""></img>
            <h1 className ="h3 fst-italic">Real World App</h1>
            <h2 className="h4">Sign Up</h2>
            </div>
        </div>
        <div className = "offset-4 col-4">

<form onSubmit={handleSubmit}>
<div className="form-group">
<label htmlFor="firstName">First Name</label>
<input
          type="text"
          className="form-control"
          id="firstName"
          name="firstName"
          value={firstName}
          onChange={handleChange}
        />
</div>
<div className="form-group">
<label htmlFor="lastName">Last Name</label>
<input
          type="text"
          className="form-control"
          id="lastName"
          name="lastName"
          value={lastName}
          onChange={handleChange}
        />
</div>
<div className="form-group">
<label htmlFor="username">Username</label>
<input
          type="text"
          className="form-control"
          id="username"
          name="username"
          value={username}
          onChange={handleChange}
        />
</div>
<div className="form-group">
<label htmlFor="password">Password</label>
<input
          type="password"
          className="form-control"
          id="password"
          name="password"
          value={password}
          onChange={handleChange}
        />
</div>
<div className="form-group">
<label htmlFor="confirmPassword">Confirm Password</label>
<input
          type="password"
          className="form-control"
          id="confirmPassword"
          name="confirmPassword"
          value={confirmPassword}
          onChange={handleChange}
        />
</div>
<button type="submit" className="btn btn-primary mt-4 px-5">SIGN UP</button>
</form>
</div>
</div>
  );
}

 

export default Signup;