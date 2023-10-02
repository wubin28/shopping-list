<script setup lang="ts">
import { ref } from 'vue'
import { ElForm, ElFormItem, ElInput, ElButton } from 'element-plus'

const formInput = ref({ title: '', purchased: false })

const onSubmit = () => {
  console.log('ShoppingItem', formInput.value)
}
</script>

<template>
  <el-form @submit.prevent :inline="true" :model="formInput" class="shopping-item-form-input">
    <el-form-item label="Title" prop="title">
      <el-input v-model="formInput.title" placeholder="Enter Title"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit()">Add</el-button>
    </el-form-item>
  </el-form>
</template>

<style scoped></style>
