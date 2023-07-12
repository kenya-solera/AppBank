import * as React from 'react';
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
import {useNavigate} from "react-router-dom";
import { ExitToAppSharp } from '@mui/icons-material';


// TODO remove, this demo shouldn't need to reset the theme.

const defaultTheme = createTheme();


export default function SignIn() {

  
  let navigate = useNavigate()

  const [user, setUser] = useState({
    firstName:"",
    lastName:"",
    userName:"",
    password:""
    });


    // TODO: try catch para ver si la transacción es 200
    // función comprobar contraseñas coinciden
    // función comprobar contraseña cumple seguridad
    // función comprobar nombre tiene mas un caracter
    // función comprobar apellido tiene más de un caracter
    
  const handleSubmit = async (event) => {
    event.preventDefault();
    await axios.post("http://localhost:8081/users", user);
    navigate(login)
  };

  const {firstName, lastName, userName, password} = user;

  const onInpuChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
    
  };


  return (
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
            Sign Up
          </Typography>
          <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
          <TextField
              margin="normal"
              required
              fullWidth
              type={"text"}
              value={firstName}
              id="firstName"
              label="First Name"
              name="firstName"
              autoComplete="firstName"
              autoFocus
              onChange={(e) => onInpuChange(e)}
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
              required
              fullWidth
              value={userName}
              id="userName"
              label="username"
              name="userName"
              autoComplete="username"
              autoFocus
              onChange={(e) => onInpuChange(e)}
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              value={password}
              autoComplete="current-password"
              onChange={(e) => onInpuChange(e)}
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="confirmpassword"
              label="Confirm Password"
              type="password"
              id="confirmPassword"
              onChange={(e) => onInpuChange(e)}
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Sign Up
            </Button>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}