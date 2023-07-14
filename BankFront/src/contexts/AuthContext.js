import { createContext, useContext,useState } from "react";
import axios from 'axios';

const AuthContext = createContext();

const initialAuth = false;


export const AuthProvider = ({children}) => {

    const [auth, setAuth] = useState(initialAuth);

    function logIn(user){
        try {
            axios.get('http://localhost:8081/users', user.userName);
            setAuth(true);
            console.log(user);
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