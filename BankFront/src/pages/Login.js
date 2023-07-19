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
import {useState, useContext} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import { ExitToAppSharp } from '@mui/icons-material';
import {AuthProvider} from '../contexts/AuthContext';
import AuthContext from '../contexts/AuthContext'


//console.log(AuthProvider)

const defaultTheme = createTheme();

export default function Login() {

  const {auth, handleAuth, logIn} = useContext(AuthContext); 
  
  let navigate = useNavigate()
  
  const [user, setUser] = useState({
    userName:"",
    password:""
    });

    
  const handleSubmit = async (event) => {
    event.preventDefault();
    logIn(user);
    //console.log(user);
    handleAuth(auth);
    if(auth){
        console.log("usuario autenticado");
        navigate(`/user/settings/${user.id}`)
      }
    else
      console.log("Las contraseñas no coiniden")

  };
  
  const {userName} = useParams();

  const {password} = user;

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
            Login
          </Typography>
          <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
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
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Log In
            </Button>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}