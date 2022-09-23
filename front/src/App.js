import { useRoutes } from "react-router-dom";
import Themeroutes from "./routes/Router";
import React, {useEffect, useState} from 'react';
import axios from 'axios';

const App = () => {
  const routing = useRoutes(Themeroutes);

  return <div className="dark">{routing}</div>;
};



// function App() {
//    const [hello, setHello] = useState('')

//     useEffect(() => {
//         axios.get('/todoList')
//         .then(response => setHello(response.data))
//         .catch(error => console.log(error))
//     }, []);

//     return (
//         <div>
//             백엔드에서 가져온 데이터입니다 : {hello}
//         </div>
//     );
// }

export default App;
