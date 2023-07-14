import React, {useEffect, useState} from 'react'
import { createTheme, ThemeProvider } from '@mui/material/styles';
import axios from 'axios';
import SideBar from '../components/SideBar'
import CssBaseline from '@mui/material/CssBaseline';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
import Avatar from '@mui/material/Avatar';
import { deepOrange } from '@mui/material/colors';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';


const defaultTheme = createTheme();
export default function Account() {

    const [text, setText] = useState()

    const textOnChange=(event) => {
        setText(event.target.value)
    }

  
  return (

    <div>

      <SideBar/>
      <ThemeProvider theme={defaultTheme}>
      <Container component="main" maxWidth="xs" 
      sx={{
            display: 'flex',
         
            justifyContent: 'flex-start',
            alignItems: "flex-start"
        }} >

        <CssBaseline />
        <Box
          sx={{
            marginTop: 25,
            display: 'flex',
            flexDirection: 'column',
            justifyContent: 'flex-start',
            alignItems: 'flex-start'
            
          }}>
        
          {/* <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
            <LockOutlinedIcon />
          </Avatar> */}
   
            <Paper sx={{ p: 8, mb: 15 }}>
                <Typography  sx={{ mb: 2}}>
                    <h2>Bank Accounts</h2>
                    O'Hara - Labadie Bank
                </Typography>
            </Paper>
            <Box sx={{ display: 'flex', justifyContent: 'flex-end', alignItems: 'flex-start' }}>
                <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
                >
                    Create
                </Button>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{  mb: 2 }}
            >
              Delete
            </Button>
          </Box>
     
           
          </Box>
          </Container>
    </ThemeProvider>
        
    </div>
  )
}


