import { createContext, useContext,useState } from "react";
import axios from 'axios';

const AuthContext = createContext();

const initialAuth = false;

let dataPassword;
export const AuthProvider = ({children}) => {

    const [auth, setAuth] = useState(initialAuth);
    const [backendPassword, setBackendPassword] = useState();

    async function logIn(user){
        console.log(user.userName);
        try {
            const response = await axios.get(`http://localhost:8081/users/get/${user.userName}`)
            
            console.log(response.data.password);
            setBackendPassword(await response.data.password);
            console.log("backendpasword:" + backendPassword)
            if(backendPassword === user.password){
                
                setAuth(true);
                console.log("Usuario autenticado")
            }
            else
                console.log("usuario no autenticado");
            
        } catch (error) {
            console.log("Usuario no encontrado");
        }
    }

    const handleAuth = (e) => {
        if(auth){
            setAuth(false);
        }else{
            setAuth(true);
        }
    }
   const data = {auth, handleAuth, logIn};

    return <AuthContext.Provider value = {data}>{children}</AuthContext.Provider>;
};

export default AuthContext;