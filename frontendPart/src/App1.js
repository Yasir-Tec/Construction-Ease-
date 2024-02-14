
import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import SignUpComponent from './Components/SignUp';

import SignInComponent from './Components/signin';

import ContractorPageComponent from './Components/ContractorPage';
import HeaderComponent from './Components/header';
import AddProjectComponent from './Components/addproject';



function App1() {
  return (
    <div class="page-wrap">
      <HeaderComponent></HeaderComponent>
      <div className="App1">
   
        <Router>
         <Routes>

            <Route path="/add-contractor" element={<SignUpComponent></SignUpComponent>}></Route>
            <Route path='/signin' element={<SignInComponent></SignInComponent>}></Route>
            <Route path='/contractorpage' element={<ContractorPageComponent></ContractorPageComponent>}></Route>
            <Route path="/addproject/:contractorId" element={<AddProjectComponent></AddProjectComponent>} />
            
      
         </Routes>
        </Router>
        </div>
  </div>


  );
}





export default App1;
