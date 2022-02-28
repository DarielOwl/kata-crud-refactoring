import React from "react";
import { StoreProvider } from './components/Utilities/Store';
import FormGroup from './components/GroupTodos/FormGroup';
import ListGroups from './components/GroupTodos/ListGroups';

function App() {
  return <StoreProvider>
    <div className="container">
      <h3>To-Do Grupos - By Dáriel de Sosa</h3>
      <FormGroup />
      <ListGroups />
    </div>
  </StoreProvider>
}

export default App;
