import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Signup from './pages/Signup';
import User from './pages/User';
import BankAccounts from './pages/BankAccounts';
import Personal from './pages/Personal';
import Transaction from './pages/Transaction';

function App() {
    return (
<div className="App">
<Router>
<Routes>
  <Route exact path="/Signup" element={<Signup/>}/>
  <Route exact path="/User" element={<User/>}/>
  <Route exact path="/BankAccounts" element={<BankAccounts/>}/>
  <Route exact path="/Personal" element={<Personal/>}/>
  <Route exact path="/Transaction" element={<Transaction/>}/>
</Routes>

</Router>
</div>
    );
  }

export default App;
