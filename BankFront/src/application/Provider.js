import React, {createContext, useState} from 'react';
import Context from '../contexts/Store';


const Provider = (props) => {

    const [user, setUser] = useState({});
  return (
    <div>
       <AppContext.Provider value={[user,setUser]}>
        {props.children}
       </AppContext.Provider>
    </div>
  );
}

export default Provider
export const AppContext = createContext();