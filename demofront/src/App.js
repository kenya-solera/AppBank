import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import NavBar from "./Layout/NavBar";
import Home from './pages/Home';
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import AddStudent from './Students.js/AddStudent';
import EditStudent from './Students.js/EditStudent';
import ViewStudent from './Students.js/ViewStudent';

function App() {
  return (
    <div className="App">
      <Router>
      <NavBar/>

      <Routes>
        <Route exact path="/" element={<Home/>}/>
        <Route exact path="/AddStudent" element={<AddStudent/>}/>
        <Route exact path="/ViewStudent/:id" element={<ViewStudent/>}/>
        <Route exact path="/EditStudent/:id" element={<EditStudent/>}/>
      </Routes>
      </Router>
    </div>
  );
}

export default App;
