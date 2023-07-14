import React from 'react'
import SideBar from '../components/SideBar'
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import axios from 'axios';
import {useState} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import { ExitToAppSharp } from '@mui/icons-material';
import {AuthProvider} from '../contexts/AuthContext';
import AuthContext from '../contexts/AuthContext';
import Store from '../contexts/Store';

const defaultTheme = createTheme();
export default function UserSettings() {
  let navigate = useNavigate()
  const {auth,handleAuth} = useState(AuthContext);

  const [user, setUser] = useState({
    firstName:"",
    lastName:"",
    userName:"",
    email:"",
    phoneNumber:""
    });
    console.log(user);

  const loadUser = async () => {

  };
  loadUser();
  
    const {userName} = useParams();

    // TODO: try catch para ver si la transacción es 200
    // función comprobar contraseñas coinciden
    // función comprobar contraseña cumple seguridad
    // función comprobar nombre tiene mas un caracter
    // función comprobar apellido tiene más de un caracter
    
  const handleSubmit = async (event) => {
    event.preventDefault();
    await axios.get("http://localhost:8081/users", user);
    navigate("/user/settings")
  };

  const {firstName, lastName, email, phoneNumber} = user;

  const onInpuChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
    
  };
  return (
    <div>
      <AuthProvider>
      <SideBar/>
      <ThemeProvider theme={defaultTheme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          {/* <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
            <LockOutlinedIcon />
          </Avatar> */}
          <h2>Real World App</h2>
          <Typography component="h5" variant="h5">
            Settings
          </Typography>
          <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
          <TextField
          id="outlined-read-only-input"
          label="First Name"
          defaultValue={firstName}
          InputProps={{
            readOnly: true,
          }}
        />


            <TextField
              margin="normal"
              required
              fullWidth
              type={"text"}
              value={lastName}
              id="lastName"
              label="Last Name"
              name="lastName"
              autoComplete="lastname"
              autoFocus
              onChange={(e) => onInpuChange(e)}
            />
            <TextField
              margin="normal"
              fullWidth
              value={email}
              id="email"
              label="email"
              name="email"
              autoComplete="email"
              autoFocus
              onChange={(e) => onInpuChange(e)}
            />
            <TextField
              margin="normal"
              fullWidth
              name="phoneNumber"
              label="phoneNumber"
              type="phoneNumber"
              id="phoneNumber"
              value={phoneNumber}
              onChange={(e) => onInpuChange(e)}
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Save
            </Button>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
    </AuthProvider>
    </div>
  )
}

