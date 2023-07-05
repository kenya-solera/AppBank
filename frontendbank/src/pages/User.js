import React from "react";
import Sidebar from "../components/Sidebar";

const User = () => {
  return (
    <div className="container text-center">
    <div className="row">
      <div className="col-3">
        <Sidebar/>
      </div>
      <div className="col-4">
        <img src="../img/settings_900834.png"></img>
      </div>
      <div className="col-5">
      <form onSubmit="">
<div className="form-group">
<label htmlFor="firstName">First Name</label>
<input
          type="text"
          className="form-control"
          id="firstName"
          name="firstName"
          
        />
</div>
<div className="form-group">
<label htmlFor="lastName">Last Name</label>
<input
          type="text"
          className="form-control"
          id="lastName"
          name="lastName"
        
        />
</div>
<div className="form-group">
<label htmlFor="username">Username</label>
<input
          type="text"
          className="form-control"
          id="username"
          name="username"
        />
</div>
<div className="form-group">
<label htmlFor="password">Password</label>
<input
          type="password"
          className="form-control"
          id="password"
          name="password"
        />
</div>
<button type="submit" className="btn btn-primary">Save</button>
</form>
        </div>
      </div>
    </div>

  );
};

export default User;
