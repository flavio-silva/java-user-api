<template>
  <div>
    <div class="container mt-5">
      <h1 class="text-center h2">Cadastro de usuários</h1>

      <form
        class="mt-5"
        v-on:submit.prevent="save(user)"
      >

        <div class="form-row">
          <div class="form-group col-lg-6">
            <label
              for="firstName"
              class="col-form-label font-weight-bold"
            >Nome: <span class="text-danger">*</span></label>
            <input
              name="firstName"
              id="firstName"
              type="text"
              class="form-control"
              placeholder="Digite o seu nome"
              required
              v-model="user.firstName"
            />
          </div>

          <div class="form-group col-lg-6">
            <label
              for="lastName"
              class="col-form-label font-weight-bold"
            >Sobrenome: <span class="text-danger">*</span></label>
            <input
              type="text"
              name="lastName"
              id="lastName"
              class="form-control"
              placeholder="Digite seu sobrenome"
              required
              v-model="user.lastName"
            />
          </div>
        </div>

        <div class="form-row">
          <div class="form-group col-lg-8">
            <label
              for="email"
              class="font-weight-bold col-form-label"
            >Email: <span class="text-danger">*</span></label>
            <input
              type="email"
              name="email"
              id="email"
              class="form-control"
              placeholder="meuemail@email.com.br"
              required
              v-model="user.email"
            >
          </div>

          <div class="form-group col-lg-4">
            <label
              for="gender"
              class="font-weight-bold col-form-label"
            >Sexo: <span class="text-danger">*</span></label>
            <select
              name="gender"
              id="gender"
              class="form-control"
              required
              v-model="user.gender"
            >
              <option
                value=""
                selected
              >Selecione o sexo</option>
              <option value="m">Masculino</option>
              <option value="f">Feminino</option>
            </select>
          </div>
        </div>

        <div class="form-row">
          <div class="form-group col-lg-9">
            <label
              for="address"
              class="font-weight-bold col-form-label"
            >Endereço: <span class="text-danger">*</span></label>
            <input
              type="text"
              name="address"
              id="address"
              placeholder="Digite o seu endereço"
              class="form-control"
              required
              v-model="user.address"
            >
          </div>
          <div class="form-group col-lg-3">
            <label
              for="telephone"
              class="font-weight-bold col-form-label"
            >Telefone: <span class="text-danger">*</span></label>
            <input
              type="text"
              name="telephone"
              id="telephone"
              class="form-control"
              placeholder="(XX) X-XXXX-XXXX"
              required
              v-model="user.telephone"
            >
          </div>
        </div>

        <div class="form-row">
          <div class="form-group col-lg-6">
            <label
              for="username"
              class="font-weight-bold col-form-label"
            >Username: <span class="text-danger">*</span></label>
            <input
              type="text"
              name="username"
              id="username"
              placeholder="Sem espaços e caracteres especiais"
              class="form-control"
              required
              v-model="user.username"
            >
          </div>

          <div class="form-group col-lg-6">
            <label
              for="password"
              class="font-weight-bold col-form-label"
            >
              Senha: <span class="text-danger">*</span>
            </label>
            <input
              type="password"
              name="password"
              id="password"
              class="form-control"
              :placeholder="user.id ? 'Deixa em branco para a senha atual' : 'min 6 caracteres'"
              minlength="6"
              maxlength="80"
              :required="!user.id"
              v-model="user.password"
            />
          </div>
        </div>
        <button
          type="submit"
          class="btn btn-primary"
          :disabled=loading
        >
          <span
            class="fa"
            :class="{ 'fa-save' : !loading, 'fa-spinner': loading, 'fa-spin': loading}"
          ></span>
          &nbsp; Salvar</button>

      </form>

      <h2 class="text-center my-5">Listagem de usuários</h2>

      <table
        class="table table-hover table-responsive"
        v-if="users.length"
      >
        <thead>
          <tr>
            <th>Nome</th>
            <th>Sobrenome</th>
            <th>Email</th>
            <th>Sexo</th>
            <th>Endereço</th>
            <th>Telefone</th>
            <th>Username</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="user in users"
            :key="user.id"
          >
            <td>{{ user.firstName }} </td>
            <td>{{ user.lastName }} </td>
            <td>{{ user.email }} </td>
            <td>{{ user.gender === 'm' ? 'Masculino' : 'Feminino' }} </td>
            <td>{{ user.address }} </td>
            <td>{{ user.telephone }} </td>
            <td>{{ user.username }} </td>
            <td class="d-flex justify-content-between">
              <a
                href="#"
                v-on:click.prevent="fillUserInfo(user)"
                class="fa fa-edit"
              ></a>

              <a
                href="#"
                v-on:click.prevent="deleteUser(user.id)"
                class="fa fa-trash text-danger"
              ></a>
            </td>
          </tr>
        </tbody>
      </table>
      <p
        v-else
        class="text-center"
      >
        Nenhum usuário cadastrado
      </p>
    </div>
    <footer class="bg-dark mt-5">
      <p class="text-center text-white p-5 mb-0">
        Todos os direitos reservados &copy;
      </p>

    </footer>
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.min.css'
import 'font-awesome/css/font-awesome.css'
import api from './services/api';
import Swal from 'sweetalert2';

export default {
  name: 'app',

  created () {
    api.get().then(response => {
      this.users = response.data;
    })
  },

  data () {
    return {
      loading: false,
      user: { gender: '' },
      users: [],
    }
  },
  methods: {
    async save (user) {
      this.loading = true;

      const method = user.id ? 'put' : 'post';

      api[method]('/', user).then(response => {

        Swal.fire(
          `Usuário ${user.id ? 'alterado' : 'cadastrado'} com sucesso!`,
          '',
          'success'
        )

        if (!user.id) {
          this.users.push(response.data);
        }

        this.user = { gender: '' }
      }).catch(() => {
        Swal.fire({
          type: 'error',
          text: 'Erro ao cadastrar o usuário',
        })

      }).finally(() => {
        this.loading = false;
      })
    },
    fillUserInfo (user) {
      this.user = user;
    },
    deleteUser (id) {
      Swal.fire({
        title: 'Exclusão de usuário',
        text: 'Tem certeza que quer excluir o usuário.',
        type: 'warning',
        confirmButtonText: 'Confirmar',
        showCancelButton: true,
        cancelButtonText: 'Cancelar',
      }).then(result => {

        if (!result.value) return;

        api.delete(`/${id}`).then(() => {
          const userIndex = this.users.findIndex(user => user.id === id)
          this.users.splice(userIndex, 1);

          Swal.fire(
            'Usuário excluído com sucesso!',
            '',
            'success'
          )
        }).catch(() => {
          Swal.fire({
            type: 'error',
            title: 'Erro ao excluir o usuário!'
          })
        })
      })
    }
  }
}
</script>
