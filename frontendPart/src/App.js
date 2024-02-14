
import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';

import FooterComponent from './Components/FooterComponent';

import ListContractorsComponent from './Components/ListContractorsComponent';
import AddContractorComponent from './Components/AddContractorComponent';
import LayoutComponent from './Components/layout';
import HeaderComponent from './Components/header';
import SignUpComponent from './Components/SignUp';
import ImageUpload from './Components/ImageUpload';
import ContractorImage from './Components/ContractorImage';
import ImageUploadMany from './Components/uploadMultiple';


function App() {
  return (
    <div class="page-wrap">
     
      <div className="App">
   
        <Router>
         <Routes>
            <Route path="/" element={<LayoutComponent></LayoutComponent>}></Route>
            <Route path='/upload' element={<ImageUpload></ImageUpload>}></Route>
            <Route path='/uploadMany' element={<ImageUploadMany></ImageUploadMany>}></Route>
            <Route path='/upload/:id' element={<ContractorImage></ContractorImage>}></Route>
            
         </Routes>
        </Router>
        </div>
  </div>


  );
}





export default App;
