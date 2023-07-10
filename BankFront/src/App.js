import logo from './logo.svg';
import './App.css';
import {React} from 'react';
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';
import SignIn from './pages/SingUp';
import User from './pages/User';


function App() {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<SignIn/>}/>
        <Route exact path="/user" element={<User/>}/>
      </Routes>
      
    </Router>
  );
}

export default App;
