import logo from './logo.svg';
import './App.css';
import {React} from 'react';
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';
import SignIn from './pages/SingUp';
import Login from './pages/Login';
import UserSettings from './pages/UserSettings';
import Store from './contexts/Store';
import { AuthProvider } from './contexts/AuthContext';


function App() {
  return (
    <AuthProvider>
    <Store>
    <Router>
      <Routes>
        <Route exact path="/" element={<SignIn/>}/>
        <Route exact path= "/login" element={<Login/>}> </Route>
        <Route exact path="/user/settings/:id" element={<UserSettings/>}/>
        <Route exact path="/account" element ={<Account/>} />
        <Route exact path="/personal" element={<Transactions/>}/>
      </Routes>
    </Router>
    </Store>
    </AuthProvider>
  );
}

export default App;
