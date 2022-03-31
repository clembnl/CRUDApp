<template>
  <form @submit="onSubmit" class="add-form">
    <div class="form-control">
      <label>Name : </label>
      <input type="text" v-model="name" name="name" placeholder="Name" />
    </div>
    <div class="form-control">
      <label>Email : </label>
      <input type="email" v-model="email" name="email" placeholder="Email" />
    </div>
    <div class="form-control">
      <label>Adress : </label>
      <input type="text" v-model="adress" name="adress" placeholder="Adress" />
    </div>        
    <div class="form-control">
      <label>Arrival : </label>
      <input
        type="date" v-model="arrival" name="arrival" placeholder="Arrival" />
    </div>

    <input type="submit" value="Add Employee" class="btn" />
  </form>    
</template>

<script>
export default {
    name: 'AddForm',
    data() {
        return {
            name: '',
            email: '',
            adress: '',
            arrival: '',
        }
    },
    methods: {
        onSubmit(e) {
            e.preventDefault()

            const employee = {
                name: this.name,
                email: this.email,
                adress: this.adress,
                arrival: this.arrival
            }

            this.$emit('add-employee', employee)

            this.name = ''
            this.email = ''
            this.adress = ''
            this.arrival = ''
        }
    }
}
</script>

<style>
.add-form {
  border-top: solid 1px rgb(210,210,210);
  padding-top: 20px;
  margin: 20px;
  font-family: 'Poppins', sans-serif;
  display: flex;
  justify-content: space-around;
}

.form-control input {
  padding: 3px 7px;
  color: rgb(180, 180, 180);
}

.form-control :hover {
  outline: 1px solid black;
}

.form-control :focus {
  outline: 1px solid black;
  color: black;
  font-family: 'Rubik', sans-serif;
}

.form-control input::placeholder {
  color: rgb(180, 180, 180);
  font-family: 'Poppins', sans-serif;
}

.btn {
  background-color: rgb(77, 84, 180);
  border: none;
  border-radius: 1px;
  padding: 6px 12px 6px 12px;
  color: white;
  font-weight: bold;
}
</style>