package com.example.jetpackproject

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.jetpackproject.model.IpfsData
import com.example.jetpackproject.model.OnChainMetaData
import com.example.jetpackproject.model.ViewState
import com.example.jetpackproject.ui.NftRepository
import com.example.jetpackproject.ui.StakePoolViewModel
import com.example.jetpackproject.util.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class StakePoolViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var nftRepository: NftRepository

    lateinit var viewModel: StakePoolViewModel

    @Mock
    private lateinit var nftViewModelObserver: Observer<ViewState<String>>

    @Before
    fun setUp() {
        viewModel = StakePoolViewModel(nftRepository)
        viewModel.screenState.observeForever(nftViewModelObserver)
    }

    @After()
    fun tearDown() {
        viewModel.screenState.removeObserver(nftViewModelObserver)
    }

    @Test
    fun `should return nft data when fetching wallet`() {
        testCoroutineRule.runBlockingTest {
            val ipfsData = IpfsData(OnChainMetaData("random1234"))
            val flow = flow {
                emit(ipfsData)
            }
            viewModel.walletId.id = "stake12344"

            `when`(nftRepository.getNftDataFromWallet(viewModel.walletId.id)).thenReturn(flow)


            viewModel.fetchWallets()

            verify(nftViewModelObserver).onChanged(ViewState.loading())


            verify(nftRepository).getNftDataFromWallet(viewModel.walletId.id)

            verify(nftViewModelObserver).onChanged(ViewState.success("random1234"))
        }
    }


}