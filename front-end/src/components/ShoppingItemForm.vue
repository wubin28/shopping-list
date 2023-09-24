<script setup lang="ts">
import { ref } from 'vue'
import { ElInput, ElForm, ElFormItem, ElButton } from 'element-plus'

const formInput = ref({ title: '', completed: false })

const onSubmit = () => {
  console.log('ShoppingItem', formInput.value)
}
</script>

<template>
  <el-form @submit.prevent :inline="true" :model="formInput" class="shopping-item-form-input">
    <el-form-item label="Title" prop="title">
      <el-input v-model="formInput.title" placeholder="Enter Shopping Item"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit()">Add</el-button>
    </el-form-item>
  </el-form>
</template>

<style scoped></style>
