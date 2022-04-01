<template>
    <form @submit="onSubmit" class="upd-form">
        <div class="form-control">
            <label>Name : </label>
            <input type="text" v-model="name" name="name" :placeholder="[employee.name]" />
        </div>
        <div class="form-control">
            <label>Email : </label>
            <input type="email" v-model="email" name="email" :placeholder="[employee.email]" />
        </div>
        <div class="form-control">
            <label>Adress : </label>
            <input type="text" v-model="adress" name="adress" :placeholder="[employee.adress]" />
        </div>        
        <div class="form-control">
            <label>Arrival : </label>
            <input type="date" v-model="arrival" name="arrival" :placeholder="[employee.arrival]" />
        </div>

        <input type="submit" value="Update Employee" class="btn" />
    </form>    

</template>

<script>
export default {
    name: 'UpdateForm',
    props: {
        employee: Object
    },    
    data() {
        return {
            id: this.employee.id,
            name: this.employee.name,
            email: this.employee.email,
            adress: this.employee.adress,
            arrival: this.employee.arrival,
        }
    },
    methods: {
        onSubmit(e) {
            e.preventDefault()

            this.employee.name = this.name
            this.employee.email = this.email
            this.employee.adress = this.adress
            this.employee.arrival = this.arrival

            this.$emit('upd-employee', this.employee)
        }
    },
    emits: ['upd-employee']
}
</script>

<style>
.upd-form {
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

@media only screen and (max-width: 660px) {
    .upd-form {
      flex-direction: column;
    }

    .form-control input{
      margin: 5px;
    }

    .btn {
      margin-top: 5px;
      width: 30%
    }
}
</style>